
package classes;


public class EVENTS{
  int id;
  String rdate;
  String rtime;
  String type;
  String place;
  boolean notify;


  public EVENTS(int id,String rdate, String rtime, String type, String place, boolean notify) {
      this.id=id;
      this.rdate=rdate;
      this.rtime=rtime;
      this.type=type;
      this.place=place;
      this.notify=notify;  
  }
 
  public int getId(){return id;}
  public String getDate(){return rdate;}
  public String getTime(){return rtime;}
  public String getType(){return type;}
  public String getPlace(){return place;}
  public boolean getNotify(){return notify;}  
}
