package horstmann;

import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import javax.swing.*;

public class ChartComponent extends JComponent{

		private double[] values;   //массив значений для построения гистограммы
		private String[] names;	   //массив меток гистограммы
		private String title;		//заголовок
		
		public ChartComponent (double[] v , String[] n, String t) {
			//System.out.println("chartComponent");
			values = v;
			names=n;
			title = t;			
		}
		
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			System.out.println("chartComponent");
			//вычисляем max min
			if (values==null)return;
			double minValue = 0;
			double maxValue = 0;
			for(double v: values ) {
			if(minValue>v) minValue=v;
			if(maxValue<v) maxValue=v;
			}
			if (maxValue==minValue) return;
			int panelWidth = getWidth();
			int panelHeight = getHeight();
			
			Font titleFont = new Font("SansSerif", Font.BOLD,20);
			Font labelFont = new Font("SansSerif", Font.PLAIN,10);
			
			//вычислить протяжность заголовка
			FontRenderContext context = g2.getFontRenderContext();
			Rectangle2D titleBounds = titleFont.getStringBounds(title, context);
			double titleWidth = titleBounds.getWidth();
			double top = titleBounds.getHeight();
			
			//воспроизвести заголовок
			double y = -titleBounds.getY();
			double x = (panelWidth-titleWidth)/2;
			g2.setFont(titleFont);
			g2.drawString(title, (float) x, (float) y);
			
			//выислить протяженость меток гистограммы
			LineMetrics labelMetrics = labelFont.getLineMetrics("", context);
			double bottom =labelMetrics.getHeight();
			
			y = panelHeight - labelMetrics.getDescent();
			g2.setFont(labelFont);
			
			//получить масштабный коэфициент и ширину столбиков гистограммы
			double scale = (panelHeight-top-bottom) / (maxValue-minValue);
			int barWidth = panelWidth/values.length;
			
			//нарисовать столбики гистограммы
			for(int i =0; i<values.length; i++) {
				//получить координаты прямоугольного столбика гистограммы
				double x1= i*barWidth+1;
				double y1= top;
				double height = values[i]*scale;
				if(values[i]>=0) y1 +=(maxValue - values[i]) * scale;
				else
				{
					y1+=maxValue * scale;
					height = -height;
				}
				// заполнить столбик гистограммы и обвести контуром
				Rectangle2D rect = new Rectangle2D.Double(x1,y1,barWidth-2, height);
				g2.setPaint(Color.RED);
				g2.fill(rect);
				g2.setPaint(Color.BLACK);
				g2.draw(rect);
				//воспроизвести отцентрованную метку под столбиком гистограммы
				Rectangle2D labelBounds = labelFont.getStringBounds(names[i], context);
				
				double labelWidth = labelBounds.getWidth();
				x = x1 + (barWidth-labelWidth) / 2;
				g2.drawString(names[i], (float) x,(float) y);
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
}
