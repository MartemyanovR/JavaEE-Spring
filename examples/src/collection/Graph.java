package collection;

//обход в глубину

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // Массив вершин
	private int adjMat[][]; // Матрица смежности
	private int nVerts; // Текущее количество вершин
	private GraphStack theStack;
	// -------------------------------------------------------------
	public Graph() // Конструктор
	{
		vertexList = new Vertex[MAX_VERTS];
		// Матрица смежности
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++) // Матрица смежности
			for(int k=0; k<MAX_VERTS; k++) // заполняется нулями
				adjMat[j][k] = 0;
		theStack = new GraphStack(MAX_VERTS);
	}
	// -------------------------------------------------------------
	public void addVertex(char lab) // В аргументе передается метка
	{
		vertexList[nVerts++] = new Vertex(lab);
	}
	// -------------------------------------------------------------
	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	// -------------------------------------------------------------
	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
		}
	
	// Метод возвращает непосещенную вершину, смежную по отношению к v
	public int getAdjUnvisitedVertex(int v)
	{
		for(int j=0; j<nVerts; j++)
		if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
		return j; // Возвращает первую найденную вершину
		return -1; // Таких вершин нет
	}
	
	public void dfs() // Обход в глубину
		{ // Алгоритм начинает с вершины 0
		vertexList[0].wasVisited = true; // Пометка
		displayVertex(0); // Вывод
		theStack.push(0); // Занесение в стек
		while( !theStack.isEmpty() ) // Пока стек не опустеет
		{
			// Получение непосещенной вершины, смежной к текущей
			int v = getAdjUnvisitedVertex( theStack.peek() );
			if(v == -1) // Если такой вершины нет,
				theStack.pop(); // элемент извлекается из стека
			else // Если вершина найдена
			{
				vertexList[v].wasVisited = true; // Пометка
				displayVertex(v); // Вывод
				theStack.push(v); // Занесение в стек
			}
		}
		// Стек пуст, работа закончена
		for(int j=0; j<nVerts; j++) // Сброс флагов
		vertexList[j].wasVisited = false;
	}
}
