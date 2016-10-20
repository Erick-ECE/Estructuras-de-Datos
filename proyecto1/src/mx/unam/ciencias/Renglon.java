package src.mx.unam.ciencias;


public class Renglon implements Comparable<Renglon>{

    public String Renglon;

    public Renglon(String s){
	this.Renglon=s;
    }

    @Override public int compareTo(Renglon c){
	return this.Renglon.compareToIgnoreCase(c.Renglon);
    }

    public String toString(){
	return this.Renglon;
    }
}
