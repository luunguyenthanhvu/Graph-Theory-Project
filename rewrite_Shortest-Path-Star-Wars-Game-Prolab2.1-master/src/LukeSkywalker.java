
// -LukeSkywalker : nhân vật tốt cho người dùng chọn
public class LukeSkywalker extends Character {

	public int lives; // so mang song(3)
	private Location location = new Location(); // lay vi tri
	public LukeSkywalker(String name, String kind,int lives,int matrixRow, int matrixCol, int startRow, int startCol) {
	super(name, kind, matrixRow, matrixCol, startRow, startCol);
	this.location.matrixRow = 5; // map [satir] [sutun] // vi tri cua nhan vat nam o hang
	this.location.matrixCol = 6;
	this.location.xAxis = 6; // vi tri toan do truc x
	this.location.yAxis = 5; // vi tri toa do truc y
	this.lives=lives; // so mang song
	}
	public String getName() {  // ten nhan vat
	return name;
	}
	public void setName(String name) {
	name = "Luke Skywalker";
	}
	public String getKind() { // loai nhan vat (tot)
	return kind;
	}
	public void setKind(String kind) {
	kind = "Iyi";
	}
	public Location getLocation() { // vi tri nhan vat(toa do x,y)
	return location;
	}
	public void setLocation(int xAxis, int yAxis) {
	this.location.xAxis = xAxis; // vi tri cua nhan vat o truc x
	this.location.yAxis = yAxis; // vi tri cua nhan vat o truc y
	//this.location = location;
	}
	public void printLocation() {
	System.out.println("xAxis : " + location.xAxis);
	System.out.println("yAxis : " + location.yAxis);
	}
	public void setMatrix(int row, int col) {
	this.location.matrixRow = row;
	this.location.matrixCol = col;
	}
	public void printMatrix() {
	System.out.println("matrix row : " + location.matrixRow);
	System.out.println("matrix col : " + location.matrixCol);
	}
	public int getLives() { // lay so luong mang con
	return lives;
	}
	public void setLives(int lives) {
	this.lives = lives;
	}
	public int decreaseLives(int lives) {/*Phuong thuc giam so mang song cua nhan vat khi die */
	return this.lives=lives-1; // giam so luong mang
	}
}