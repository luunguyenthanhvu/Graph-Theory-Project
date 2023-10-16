

//  Stormstrooper : giống DathVander nhân vật xấu 
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Stormtrooper extends Character {

    int stormtrooperNumber;

    public Stormtrooper(String name, String kind, int matrixRow, int matrixCol,int startRow,int startCol) {
        super(name, kind, matrixRow, matrixCol,startRow,startCol);
    }

  /*  public Stormtrooper(String name, String kind) {
        super(name, kind);
    }*/
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = "Stromtrooper";
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        kind = "Kotu";
    }

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }
    public int getStormtrooperNumber() {
        return stormtrooperNumber;
    }

    public void setStormtrooperNumber(int stormtrooperNumber) {
        this.stormtrooperNumber = stormtrooperNumber;
    }

    @Override
	public int characterMoveX(int currentX, int nextX) {
		return super.characterMoveX(currentX, nextX);
	}

	@Override
	public int characterMoveY(int currentY, int nextY) {
		return super.characterMoveY(currentY, nextY);
	}
	
	// Kích thước của mê cung nhị phân
	
    private static final int rowNum = 11;
    private static final int colNum = 14;

	// Các mảng bên dưới nêu chi tiết tất cả 4 chuyển động có thể có từ một ô
	// điều này có thể không cần thiết, nó có thể được thay đổi
    
    private static final int row[] = {-1, 0, 0, 1};
    private static final int col[] = {0, -1, 1, 0};

/* Chức năng này có chức năng năng kiểm tra xem có thể đi đến vị trí (hàng, cột) 
 * 		từ vị trí hiện tại hay không. Hàm trả về false nếu (hàng, cột) không phải là 
 *  		vị trí hợp lệ hoặc có giá trị 0 hoặc nó đã được truy cập
 *   
*/

    private static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
        return (row >= 0) && (row < rowNum) && (col >= 0) && (col < colNum)
                && mat[row][col] == 1 && !visited[row][col];
        
/* + Vị trí đang xét năm trong phạm vi của ma trận, tức là có đủ hàng và cột để truy cập tới nó
 * + Giá trị của ô vị trí đang xét là 1;
 * + Ô vị trí đang xét chưa được duyệt( được đánh dấu là 'false' trong ma trận 'visited')
 *  ==> Nếu thỏa ĐK hàm trả về 'true' , ngược lại trả về 'fasle'
 */
    }

    public Queue<Location> q = new ArrayDeque<>();

    
    @Override
	public ArrayList<Location> kopyala(ArrayList<Location> kopyagel) {
		return super.kopyala(kopyagel);
		// kopyagel : sao chép
	}

    // Thuật toán kiểm tra đường đi ngắn nhất duyệt bằng BFS tìm điểm bắt đầu và điểm kết thúc trên ma trận
    
    @Override
    public Queue<Location> shortestPath(int mat[][], int i, int j, int x, int y) {
    	/* khai báo các biến
    	 * 		mat: ma trận đầu vào
    	 * 		i: chỉ số hàng của điểm bắt đầu
    	 * 		j: chỉ số cột của điểm bắt đầu
    	 *  	x: chỉ số hàng của điểm kết thúc
    	 *    	j: chỉ số cột của điểm kết thúc
    	 */
    	
    	/* sẽ chỉnh sửa sau */

    	// Xây dựng một ma trận boolean 'visited' để theo dõi các ô đã truy cập.
 
        boolean[][] visited = new boolean[rowNum][colNum];

        // create an empty queue -- tạo một hàng đợi trống
        // Queue<Location> q = new ArrayDeque<>();
        // Hàm trả về một hàng đợi(queue) chứa các vị trí đường đi từ điểm bắt dầu đến điểm kết thúc
        // đánh dấu ô nguồn là đã truy cập và liệt kê nút nguồn
        
        visited[i][j] = true;
		// Sau đó, nó khởi tạo một hàng đợi rỗng và đánh dấu điểm bắt đầu đã được truy cập 
		// và được thêm vào hàng đợi với khoảng cách bằng 0.
        
        q.add(new Location(i, j, 0));

   	 	// Sử dụng một biến 'min_dist' để lưu trữ độ dài đường đi ngắn nhất từ diểm bắt đầu dến điểm kết thúc

        int min_dist = Integer.MAX_VALUE;

        // vòng lặp while thực hiện thuật toán BFS chạy cho đến khi hàng đợi không rỗng
        
        while (!q.isEmpty()) {
        	
        // bật nút phía trước từ hàng đợi và xử lý nó
            Location node = q.poll();

         // (i, j) đại diện cho ô hiện tại và dist lưu trữ ô đó

            i = node.matrixRow;
            j = node.matrixCol;
            int dist = node.distance;

            // nếu tìm thấy đích, cập nhật min_dist và dừng
            
            if (i == x && j == y) {
                min_dist = dist;

                for (int it = 0; it < node.path.size(); it++) {

                    System.out.println("------" + node.path.get(it).getMatrixRow() + "  " + node.path.get(it).getMatrixCol());
                }
                deneme = kopyala(node.path);
                break;
            }

            // kiểm tra tất cả 4 chuyển động có thể từ ô hiện tại
             // và liệt kê từng chuyển động hợp lệ

            for (int k = 0; k < 4; k++) {
       
            	// kiểm tra xem có thể đi đến vị trí
                 // (i + row[k], j + col[k]) từ vị trí hiện tại
            	
                if (isValid(mat, visited, i + row[k], j + col[k])) {
                	
                	// đánh dấu ô tiếp theo là đã truy cập và liệt kê nó
                	
                    visited[i + row[k]][j + col[k]] = true;

                    Location tt = new Location(i + row[k], j + col[k], dist + 1);
                    tt.path = (ArrayList<Location>) node.path.clone();
                    tt.path.add(tt);

                    q.add(tt);
                    //q.add(new Location(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            System.out.println("Đường đi ngắn nhất từ nguồn đến đích "
                    + "có độ dài là " + min_dist);
        } else {
            System.out.println("Không thể truy cập đích từ nguồn");
        }
        System.out.println("\n stormtrooper");
        return q;
    }

    // Phương thức thêm người lính vào Character
    public Character addStormtrooper(Character Stormtrooper) {
        Stormtrooper.setName("Stormtrooper" + stormtrooperNumber);
        Stormtrooper.setKind("Kotu");
        
        //Stormtrooper.setLocation(location); 
        //Stormtrooper.set Vị trí (vị trí); // sửa chữa ; Hiện tại không rõ cách tạo vị trí
        return Stormtrooper;
    }

    // Phương thức tăng thêm số lượng người lính
    public void incrementStormtrooperNumber() {
        this.stormtrooperNumber++;
    }
}