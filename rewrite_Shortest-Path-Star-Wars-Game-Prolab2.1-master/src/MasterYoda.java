
// -MasterYoda : giống nhân vật tốt lukeSkyWalker
public class MasterYoda extends Character {
private Location location = new Location(); // thiet lap vi tri cua masterYoda
public MasterYoda(String name, String kind,int lives,int matrixRow, int matrixCol,int startRow,int startCol) { // ke thua tu lop nhan vat
super(name, kind, matrixRow, matrixCol,startRow,startCol); // ten nv, loai nv, so hang, cot, vi tri bat dau o hang , cot
this.location.matrixRow = 5; // vi tri cua nhan vat tai hang
this.location.matrixCol = 6; // vi tri cua nhan vat tai cot
this.location.xAxis = 6; // vi tri cua nhan vat toa do x
this.location.yAxis = 5;  // vi tri cua nhan vat tai toa do y
/*Chuyen dong trai phai tren ma tran thay doi doi so cot*/
this.lives=lives;  // so mang con 
}
public String getName() {
return name;
}
public void setName(String name) { // ten cua nhan vat
name = "Master Yoda";
}
public String getKind() {  // lay ra loai nhan vat(tot)
return kind;
}
public void setKind(String kind) {
kind = "Iyi";
}
public Location getLocation() {
// System.out.println("Master Yoda Current xAxis :"+location.xAxis); // vi tri cua masterYoda nam o toa do x
// System.out.println("Master Yoda Current yAxis :"+location.yAxis); // vi tri cua masterYoda nam o toa do y

return location; // return ra vi tri toa do truc x truc y cua nhan vat
}
public void setLocation(int xAxis, int yAxis) { // set vi tri toa do x,y nhan vat 
this.location.xAxis = xAxis; 
this.location.yAxis = yAxis;
// this.location = location;
}
public void printLocation() { // in ra toa do truc cua nhan vat
System.out.println("xAxis : " + location.xAxis);
System.out.println("yAxis : " + location.yAxis);
}
public void setMatrix(int row, int col) {  // set ma tran co so hang so cot 
this.location.matrixRow = row;
this.location.matrixCol = col;
}
public void printMatrix() { // in ma tran ra
System.out.println("matrix row : " + location.matrixRow);
System.out.println("matrix col : " + location.matrixCol);
}
public int getLives() {  // lay ra so mang con
return lives;
}
public void setLives(int lives) {
this.lives = lives;
}
public int decreaseLives(int lives) {/* Phuong thuc nay de giam so luong truc tiep  */
return this.lives=lives-1;
}
}