

import java.util.ArrayList;

//-Location : lớp con chứa vị trí tọa
public class Location {// vi tri

	int xAxis = 0, yAxis = 0, distance = 0; // truc x, truc y, khoang cach
	int matrixRow = 0, matrixCol = 0; // hang ma tran, cot ma tran

	ArrayList<Location> path;

	Location(int matrixRow, int matrixCol, int distance) {
		path = new ArrayList<Location>();
		this.matrixRow = matrixRow;
		this.matrixCol = matrixCol;
		this.distance = distance;
	}

	Location() {
		/* hàm tạo mặc định cho các ký tự tốt để sử dụng */
	}

	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getMatrixRow() {

		return matrixRow;
	}

	public void setMatrixRow(int matrixRow) {
		this.matrixRow = matrixRow;
	}

	public int getMatrixCol() {
		return matrixCol;
	}

	public void setMatrixCol(int matrixCol) {
		this.matrixCol = matrixCol;
	}

}
