package jvm;
/********************************************************************

Copyright (c) 1996 Artima Software Company. All Rights Reserved.

PROJECT:	JavaWorld
MODULE:		Under The Hood
FILE:		GettingLoaded.java

AUTHOR:		Bill Venners, June 1996

DESCRIPTION:

This file contains all the code for the Java class load simulator that
accompanies the Under The Hood article titled, "The Java Class File Lifestyle".
I developed this under Symantec Cafe on Windows 95. As I developed it I had
each class in its own file, which made for very speedy compile and test
cycles. I lumped all the files together into this file to make it easier
to download.

This applet retrieves two files from the server, the Act.class file itself,
from which it gets the bytes to display along the bottom, and a text file
which contains the text that accompanies each step. Each block of text is
separated by a line of stars which contains one star for each byte consumed
by the step.

*********************************************************************/

import java.awt.*;
import java.applet.*;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URL;


@SuppressWarnings("serial")
public class GettingLoaded extends Applet
    implements Runnable {

    private URL theClassFileURL;
    private URL theActTextURL;
    private Thread runner;
    private TextArea ta = new TextArea();
    private StepNode firstNode;
    private StepNode lastNode;
    private StepNode currentNode;
    private boolean ready = false;
    private boolean jvmFinishedGobbling = false;
    private int currentGobblePosition = 0;
    private JVMPacman jvmPacman;
    private String titleString = "Getting Loaded\n\n";
    private boolean urlExceptionWasThrown = false;
    private String cantGoFurtherString = "Unfortunately this means the applet cannot go any further.\n";
    private String ioErrorMsg = "An IO Error occured while trying to read a file from the server.\n";
    private String securityErrorMsg = "An security exception occured while trying to read a file from the server.\n";
    private String urlErrorMsg = "This HTML file contains a malformed URL of a file required by this applet.\n";

    public void init() {

        super.init();

        ta.setEditable(false);

        setBackground(Color.blue);

        String url = getParameter("classURL");
        try { this.theClassFileURL = new URL(url); }
        catch (MalformedURLException e) {
            urlExceptionWasThrown = true;
            ta.setText(titleString + "Bad URL: " + url + "\n\n" + urlErrorMsg + cantGoFurtherString);
        }
        url = getParameter("textURL");
        try { this.theActTextURL = new URL(url); }
        catch (MalformedURLException e) {
            urlExceptionWasThrown = true;
            ta.setText(titleString + "Bad URL: " + url + "\n\n" + urlErrorMsg + cantGoFurtherString);
        }
        ControlPanel controlPanel = new ControlPanel();
        jvmPacman = controlPanel.getJVMPacman();
        setLayout(new BorderLayout(5, 5));

        ta.setBackground(Color.white);

        add("North", new ColoredLabel("GETTING LOADED", Label.CENTER, Color.cyan));
        add("South", controlPanel);
        add("Center", ta);
    }

    @SuppressWarnings("deprecation")
	public boolean handleEvent(Event event) {
        return super.handleEvent(event);
    }

    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Button) {
            String bname = (String) arg;
            if (bname.equals("Reset")) {
                if (ready) {
                    if (!currentNode.first()) {
                        currentNode = firstNode;
                        currentGobblePosition = 0;
                        jvmPacman.setGobblePosition(0, currentNode.getByteCount());
                        ta.setText(currentNode.getString());
                    }
                }
            }
            else if (bname.equals("Step")) {
                if (ready) {
                    if (!currentNode.last()) {
                        currentGobblePosition += currentNode.getByteCount();
                        currentNode = currentNode.getNext();
                        jvmPacman.gobbleToPosition(currentGobblePosition, currentNode.getByteCount());
                        ta.setText(currentNode.getString());
                    }
                    else {
                        if (!jvmFinishedGobbling) {
                            currentGobblePosition += currentNode.getByteCount();
                            jvmPacman.gobbleToPosition(currentGobblePosition, 0);
                            jvmFinishedGobbling = true;
                            ta.setText("(The End)");
                        }
                    }
                }
            }
            else if (bname.equals("Back")) {
                if (ready) {
                    if (!currentNode.first()) {
                        if (jvmFinishedGobbling) {
                            jvmFinishedGobbling = false;
                            currentGobblePosition -= currentNode.getByteCount();
                        }
                        else {
                            currentNode = currentNode.getPrev();
                            currentGobblePosition -= currentNode.getByteCount();
                        }
                        jvmPacman.setGobblePosition(currentGobblePosition, currentNode.getByteCount());
                        ta.setText(currentNode.getString());
                    }
                }
            }
        }
        return true;
    }

    public Insets insets() {
        return new Insets(5, 5, 5, 5);
    }

    public void start() {
        if (runner == null && !ready && !urlExceptionWasThrown) {
            runner = new Thread (this);
            runner.start();
        }
    }

    @SuppressWarnings("deprecation")
	public void stop() {
        if (runner != null) {
            runner.stop();
            runner = null;
        }
    }

    @SuppressWarnings("deprecation")
	public void run() {
        InputStream conn = null;
        DataInputStream data = null;
        String line;
        StringBuffer buf = new StringBuffer();

        ta.setText(titleString + "Loading First Of Two Files...\n");

        try {
            conn = this.theClassFileURL.openStream();
            data = new DataInputStream(new BufferedInputStream(conn));

            try {
                while (true) {
                    int unsignedByte = data.readUnsignedByte();
                    HexString hexStr = new HexString(unsignedByte, 2);
                    buf.append(hexStr.getString());
                }
            }
            catch (EOFException e) {
                jvmPacman.setText(buf.toString());
            }
            try {
                ta.setText(titleString + "Loading Second Of Two Files...\n");
                conn = this.theActTextURL.openStream();
                data = new DataInputStream(new BufferedInputStream(conn));
                buf.setLength(0);

                while ((line = data.readLine()) != null) {
                    if (line.length() > 0 && line.charAt(0) == '*') {
                        int starCount = line.length();
                        StepNode nextNode = new StepNode(buf.toString(), starCount);
                        if (firstNode == null) {
                            firstNode = nextNode;
                            lastNode = nextNode;
                        }
                        else {
                            lastNode.setNext(nextNode);
                            nextNode.setPrev(lastNode);
                            lastNode = nextNode;
                        }
                        buf.setLength(0);
                    }
                    else {
                        buf.append(line + "\n");
                    }
                }
                ready = true;
                currentNode = firstNode;
                jvmPacman.setGobblePosition(0, firstNode.getByteCount());
                ta.setText(currentNode.getString());
            }
            catch (IOException e) {
                ta.setText(titleString + "IO Error: " + e.getMessage() + "\n\n"
                    + ioErrorMsg + cantGoFurtherString);
            }
            catch (SecurityException e) {
                ta.setText(titleString + "Security Exception: " + e.getMessage() + "\n\n"
                    + securityErrorMsg + cantGoFurtherString);
            }
        }
        catch (IOException e) {
            ta.setText(titleString + "IO Error: " + e.getMessage() + "\n\n"
                    + ioErrorMsg + cantGoFurtherString);
        }
        catch (SecurityException e) {
            ta.setText(titleString + "Security Exception: " + e.getMessage() + "\n\n"
                + securityErrorMsg + cantGoFurtherString);
        }
    }
}

@SuppressWarnings("serial")
class ButtonPanel extends Panel {

    ButtonPanel() {
        setLayout(new GridLayout(3, 1, 5, 5));
        setBackground(Color.blue);
        Button b = new Button("Step");
        b.setBackground(Color.lightGray);
        add(b);
        b = new Button("Back");
        b.setBackground(Color.lightGray);
        add(b);
        b = new Button("Reset");
        b.setBackground(Color.lightGray);
        add(b);
    }

    public Insets insets() {
        // top, left, bottom, right
        return new Insets(0, 0, 0, 0);
    }
}

// The string passed to the constructor and to addText must be one line to
// be printed out, excluding a closing return.
@SuppressWarnings("serial")
class JVMPacman extends Canvas {

    private String theString;
    private boolean stringValid = false;
    private int currentGobblePosition;
    private int interestingCharsCount;
    private int charsThatFitBetweenRectanglesCount = 2;

    JVMPacman() {
        setBackground(Color.cyan);
    }

    void setText(String passedText) {

        theString = passedText;
        stringValid = true;
    }

    public Dimension minimumSize() {
        return new Dimension(110, 60);
    }
    public Dimension preferredSize() {
        return new Dimension(110, 60);
    }

    public void setGobblePosition(int pos, int interesting) {
        // Multiply the passed position by two because the passed position represents
        // a byte position whereas we want currentGobblePosition to represent a
        // character position, and there are two hex characters for each byte.
        currentGobblePosition = pos * 2;
        interestingCharsCount = interesting * 2;
        repaint();
    }

    public void gobbleToPosition(int pos, int interesting) {
        currentGobblePosition = pos * 2;
        interestingCharsCount = interesting * 2;
        repaint();
    }

    @SuppressWarnings("deprecation")
	public void paint(Graphics g) {

        Font font = getFont();
        FontMetrics fm = getFontMetrics(font);
        int heightOfOneLine = fm.getHeight();

        // Calculate x starting point
        Dimension dim = new Dimension();

        dim = size();

        int xStartingPoint = 5;

        // Calculate y starting point
        int totalHeight = heightOfOneLine * 2;
        int yStartingPoint = (dim.height - totalHeight) / 2;
        if (yStartingPoint < 5) {
            yStartingPoint = 5;
        }

        // Calculate width of JVM rectangle. This will be heightOfOneLine more than
        // the stringWidth of "JVM" which I'll write in the middle of the rectangle.
        // This will make the border around the "JVM" the same width and height on
        // all sides and will equal heightOfOneLine / 2. I'll make the height of the
        // rectangle heightOfOneLine *2.
        int jvmRectangleWidth = fm.stringWidth("JVM") + heightOfOneLine;

        // Draw the filled rectangle
        g.setColor(Color.green);
        g.fillRoundRect(xStartingPoint, yStartingPoint, jvmRectangleWidth, totalHeight,
            5, 5);

        // Give it a handsome black outline
        g.setColor(Color.black);
        g.drawRoundRect(xStartingPoint, yStartingPoint, jvmRectangleWidth, totalHeight,
            5, 5);

        // Calculate width of Server rectangle. This will be heightOfOneLine more than
        // the stringWidth of "Server" which I'll write in the middle of the rectangle.
        // This will make the border around the "Server" the same width and height on
        // all sides and will equal heightOfOneLine / 2. I'll make the height of the
        // rectangle heightOfOneLine *2.
        int serverRectangleWidth = fm.stringWidth("Server") + heightOfOneLine;

        // Draw the filled rectangle. The x starting point is the width of the
        // canvas minus the width of the server rectangle minus the 5 pixel margin.
        int xStartingPointServerRect = dim.width - serverRectangleWidth - 5;
        g.setColor(Color.green);
        g.fillRoundRect(xStartingPointServerRect, yStartingPoint,
            serverRectangleWidth, totalHeight, 5, 5);

        // Give this rectangle a handsome black outline
        g.setColor(Color.black);
        g.drawRoundRect(xStartingPointServerRect, yStartingPoint,
            serverRectangleWidth, totalHeight, 5, 5);

        int whiteRectangleWidth = xStartingPointServerRect - jvmRectangleWidth - 5;
        if (whiteRectangleWidth > 0) {

            g.setColor(Color.white);
            g.fillRect(jvmRectangleWidth + 5, yStartingPoint + (heightOfOneLine / 2),
                whiteRectangleWidth, heightOfOneLine);
        }

        // Draw "JVM" inside the rectangle
        g.setColor(Color.black);
        xStartingPoint += (heightOfOneLine / 2);
        int ascent = fm.getAscent();
        yStartingPoint += ascent + (heightOfOneLine / 2);
        g.drawString("JVM", xStartingPoint, yStartingPoint);

        // Draw "Server" inside the rectangle
        int xStartingPointServerText = xStartingPointServerRect + (heightOfOneLine / 2);
        g.drawString("Server", xStartingPointServerText, yStartingPoint);

        // The string should be written so that it fits between the JVM and Server
        // rectangles, leaving at least 5 pixels space between the rectangle and
        // the string.
        if (stringValid && currentGobblePosition < theString.length()) {

            // First need to figure out how many characters will fit in
            // the space between the two rectangles.
            int xTextStartingPoint = jvmRectangleWidth + 10;
            int xTextEndingPoint = xStartingPointServerRect - 5;
            int pixelsAvailableBetweenRectangles = xTextEndingPoint - xTextStartingPoint;
            if (pixelsAvailableBetweenRectangles < 0) {
                pixelsAvailableBetweenRectangles = 0;
            }

            // Initialize the number of characters to write as the number of
            // remaining characters. This will be reduced below if this amount of
            // characters doesn't fit.
            int charsToWriteCount = theString.length() - currentGobblePosition;

            // Check to see if the string to be displayed already fits between the
            // two rectangles. If so, we'll just use the total number of characters
            // remaining as the number of characters to write.
            int pixelWidthOfRemainingString = fm.stringWidth(theString.substring(currentGobblePosition));
            if (pixelWidthOfRemainingString > pixelsAvailableBetweenRectangles) {

                // The first while loop increments the charsThatFitBetweenTwoRectanglesCount
                // until the width of the string in pixels just exceeds the available space.
                String tryThisString = theString.substring(currentGobblePosition,
                    currentGobblePosition + charsThatFitBetweenRectanglesCount);
                int pixelsEaten = fm.stringWidth(tryThisString);
                while (pixelsEaten <= pixelsAvailableBetweenRectangles) {
                    ++charsThatFitBetweenRectanglesCount;
                    tryThisString = theString.substring(currentGobblePosition,
                        currentGobblePosition + charsThatFitBetweenRectanglesCount);
                    pixelsEaten = fm.stringWidth(tryThisString);
                }

                // The second while loop decreases the charsThatFit variable until the
                // width of the string in pixels is just under the available width.
                while (pixelsEaten > pixelsAvailableBetweenRectangles) {
                    --charsThatFitBetweenRectanglesCount;
                    tryThisString = theString.substring(currentGobblePosition,
                        currentGobblePosition + charsThatFitBetweenRectanglesCount);
                    pixelsEaten = fm.stringWidth(tryThisString);
                }

                charsToWriteCount = charsThatFitBetweenRectanglesCount;
            }

            // Draw the interesting characters in red.
            g.setColor(Color.red);
            int redCharsCount = interestingCharsCount;
            if (redCharsCount > charsToWriteCount) {
                redCharsCount = charsToWriteCount;
            }
            String redString = theString.substring(currentGobblePosition,
                currentGobblePosition + redCharsCount);
            g.drawString(redString, xTextStartingPoint, yStartingPoint);

            // Draw the remaining characters in black.
            int blackStringStartingPosition = currentGobblePosition + redCharsCount;
            int blackCharsCount = charsToWriteCount - redCharsCount;
            if (blackStringStartingPosition < theString.length()
                && blackCharsCount > 0) {

                xTextStartingPoint += fm.stringWidth(redString);
                g.setColor(Color.black);
                g.drawString(theString.substring(blackStringStartingPosition,
                    blackStringStartingPosition + blackCharsCount),
                    xTextStartingPoint, yStartingPoint);
            }
        }
    }
}

@SuppressWarnings("serial")
class ControlPanel extends Panel {

    JVMPacman jvmPacman = new JVMPacman();

    ControlPanel() {
        setLayout(new BorderLayout(5, 5));
        setBackground(Color.blue);
        add("West", new ButtonPanel());
        add("Center", jvmPacman);
    }

    public JVMPacman getJVMPacman() {
        return jvmPacman;
    }

    public Insets insets() {
        // top, left, bottom, right
        return new Insets(0, 0, 0, 0);
    }
}

class StepNode {

    private String theString;
    private StepNode next;
    private StepNode prev;
    private boolean nextValid = false;
    private boolean prevValid = false;
    private int byteCount = 0;

    StepNode(String s, int bytes) {
        theString = s;
        byteCount = bytes;
    }

    String getString() {
        return theString;
    }

    int getByteCount() {
        return byteCount;
    }

    StepNode getNext() {
        // Should probably throw an exception here if !nextValid
        return next;
    }

    void setNext(StepNode n) {
        next = n;
        nextValid = true;
    }

    boolean last() {
        return !nextValid;
    }

    StepNode getPrev() {
        // Should probably throw an exception here if !prevValid
        return prev;
    }

    void setPrev(StepNode n) {
        prev = n;
        prevValid = true;
    }

    boolean first() {
        return !prevValid;
    }
}

// I used this class because I can't seem to set the background color of
// a label.  I only want a label, but I want the backgound to be gray.
@SuppressWarnings("serial")
class ColoredLabel extends Panel {

    private Label theLabel;

    ColoredLabel(String label, int alignment, Color color) {

        setLayout(new GridLayout(1,1));

        setBackground(color);

        theLabel = new Label(label, alignment);

        add(theLabel);
    }

    public void setLabelText(String s) {

        theLabel.setText(s);
    }

    public Insets insets() {
        return new Insets(0, 0, 0, 0);
    }
}

class HexString {

    private final String hexChar = "0123456789ABCDEF";
    private StringBuffer buf = new StringBuffer();

    void Convert(int val, int maxNibblesToConvert) {

        buf.setLength(0);

        int v = val;
        for (int i = 0; i < maxNibblesToConvert; ++i) {

            if (v == 0) {

                if (i == 0) {
                    buf.insert(0, '0');
                }
                break;
            }

            // Get lowest nibble
            int remainder = v & 0xf;

            // Convert nibble to a character and insert it into the beginning of the string
            buf.insert(0, hexChar.charAt(remainder));

            // Shift the int to the right four bits
            v >>>= 4;
        }
    }

    HexString(int val, int minWidth) {

        Convert(val, minWidth);

        int charsNeeded = minWidth - buf.length();
        for (int i = 0; i < charsNeeded; ++i) {
            buf.insert(0, '0');
        }
    }

    public String getString() {

        return buf.toString();
    }
}

