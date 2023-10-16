

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
// -charater : lớp cha của các nhân vật
public class Character {

    public String name;/*tên nhân vật*/
    public String kind;/*tên đệm*/
    Location location = new Location();
    public int lives; // so mang song
	public int startRow; // vi tri bat dau o hang
	public int startCol; // vi tri bat dau o cot

    public Character(String name, String kind, int matrixRow, int matrixCol, int startRow, int startCol) {
        this.name = name;
        this.kind = kind;
        location.matrixRow = matrixRow; // vi tri hang
        location.matrixCol = matrixCol; // vi tri cot
        this.startRow=startRow;
        this.startCol=startCol;
    }
/* Đây là phương thức để nhân vật di chuyển 
 * tiến lên hay lùi lại dựa vào currentX theo trục tọa độ X
 */
        public int characterMoveX(int currentX, int nextX){
        if(nextX > currentX){
           return (currentX+1);
        }else if(nextX < currentX){
            return (currentX-1);
        }else{
            return currentX;
        }
    }
    
        /* Đây là phương thức để nhân vật di chuyển 
         * tiến lên hay lùi lại dựa vào currentY theo trục tọa độ Y
         */
        public int characterMoveY(int currentY, int nextY){
        if(nextY > currentY){
           return (currentY+1);
        }else if(nextY < currentY){
            return (currentY-1);
        }else{
            return currentY;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
// Lấy ra vị trí hiện tại của Nhân vật theo tọa độ xy
    public Location getLocation() {
//        System.out.println("Current xAxis :"+location.xAxis);
//        System.out.println("Current yAxis :"+location.yAxis);
        //System.out.println(location.distance);
        return location;
    }
// Thay đổi vị trí của nhân vật theo tọa độ xy
    public void setLocation(int xAxis, int yAxis) {
        this.location.xAxis = xAxis;
        this.location.yAxis = yAxis;
        //this.location = location;
    }
// Xuất ra màn hình vị trí của nhân vật theo tọa độ xy
    public void printLocation() {
        System.out.println("xAxis : " + location.xAxis);
        System.out.println("yAxis : " + location.yAxis);
    }
// Thay đổi vị trí  theo vị trí ma trận 2 chiều
    public void setMatrix(int row, int col) {
        this.location.matrixRow = row;
        this.location.matrixCol = col;
    }
// In màn hình vị trí  theo vị trí ma trận 2 chiều
    public void printMatrix() {
        System.out.println("matrix row : " + location.matrixRow);
        System.out.println("matrix col : " + location.matrixCol);

    }
// Mạng sống của nhân vật
    public int getLives() {
        return lives;
    }
 // Thay đổi mạng sống của nhân vật
    public void setLives(int lives) {
        this.lives = lives;
    }
// Giảm mạng sống của nhân vật
    public int decreaseLives(int lives) {/*this method for decreasing live numbers */
        return this.lives=lives-1;
    }

    // Kích thước ma trận
    private static final int rowNum = 11;
    private static final int colNum = 14;

/* Mảng ma trận này giúp nhân vật
 * di chuyển lên, xuống, trái, phải
 */
    
    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};

  /* Hàm này sẽ kiểm tra nhân vật có thể
   * đi qua vị trí có tọa độ (row,col) theo ma trận 2 chiều
   * nếu nhân vật được phép đi qua sẽ trả về true
   * ngược lại sẽ false
   */
   
    
    private static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
        return (row >= 0) && (row < rowNum) && (col >= 0) && (col < colNum)
                && mat[row][col] == 1 && !visited[row][col];
    }

//    Tạo bản sao lưu trữ danh sách vị trí đường đi
//    để lớp con có thể dùng 
    public int[] arr;

    public ArrayList<Location> kopyala(ArrayList<Location> kopyagel) {
        ArrayList<Location> kopya = new ArrayList<Location>();
        kopya = kopyagel;
        for (int i = 0; i < kopya.size(); i++) {

         //   System.out.println("-kopya-" + kopya.get(i).path.get(i).matrixRow + "," + kopya.get(i).path.get(i).matrixCol);

        }
        return kopya;
    }

	    public ArrayList<Location> deneme = new ArrayList<Location>();
	
	 
	    /* Tác giả sử dụng thuật toán Lee dựa trên BFS
	     * 
	     */
	    public Queue<Location> q = new ArrayDeque<>();
	    public ArrayList<Integer> shortestPathRows;
	    public ArrayList<Integer> shortestPathCols;
	// x y la vi tri dich, i j la vi tri hien tai
	    public Queue<Location> shortestPath(int mat[][], int i, int j, int x, int y) {
	
	        // khởi tạo mạng đã đi qua các ô để theo dõi
	        boolean[][] visited = new boolean[rowNum][colNum];
	
	        // Khởi tạo Queue
	        //Queue<Location> q = new ArrayDeque<>();
	        // Đánh dấu các ô đã đi qua và đưa vào Queue
	        visited[i][j] = true;
	        q.add(new Location(i, j, 0));
	
	        // khởi tạo biến khoảng cách ngắn nhất
	        int min_dist = Integer.MAX_VALUE;
	
	        // chạy vòng lặp cho đến khi Queue rỗng
	        while (!q.isEmpty()) {
	            // Lấy phần tử Location đầu tiên trong Queue
	            Location node = q.poll();
	
                     /* lấy vị trí theo ma trận 2 chiều 
                      * và lấy khoảng cách ngắn nhất 
                      */
	            i = node.matrixRow;
	            j = node.matrixCol;
	            int dist = node.distance;
	
	            // Nếu tìm thấy được vị trí đích thì biến min_dist sẽ nhận giá trị ngắn nhất
                // sau đó sẽ dừng vòng lặp     
	            if (i == x && j == y) {
	                min_dist = dist;
	                break;
	            }
	
	            // Vòng lặp này sẽ kiểm tra những ô xung quanh có di chuyển được hay không
           
            for (int k = 0; k < 4; k++) {
             //   Nếu ô tiếp theo di chuyển được thì sẽ đánh dấu ô này và thêm vô Queue          
                if (isValid(mat, visited, i + row[k], j + col[k])) {
                    // đánh dấu ô tiếp theo là đã truy cập và liệt kê nó
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Location(i + row[k], j + col[k], dist + 1));
                }
            }
        }
// Nếu min_dist không bằng giá trị cực đại thì sẽ in ra màn hình số bước ngắn nhất
// còn không thì in ra không tìm được khoảng cách 
        if (min_dist != Integer.MAX_VALUE) {
            System.out.println("The shortest path from source to destination "
                    + "has length " + min_dist);
        } else {
            System.out.println("Destination can't be reached from source");
        }

        return q;
    }

}