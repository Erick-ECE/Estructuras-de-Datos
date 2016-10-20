package src.mx.unam.ciencias;

import mx.unam.ciencias.edd.*;
import java.io.*;
public class proyecto1{


  private static void uso() {
      System.out.println("Uso: java -jar proyecto1.jar <archivo.txt>");
      System.exit(1);
  }

    public static void main(String[]args){

      if (args.length == 0)
          uso();


	String line = null;
	BufferedReader bufferedReader = null;
	Lista<Renglon> l= new Lista<Renglon>();

	try{
	    bufferedReader= new BufferedReader(new InputStreamReader(System.in));
	    while(bufferedReader.ready()){
		Renglon c= new Renglon(bufferedReader.readLine());
		l.agrega(c);
	    }
	    bufferedReader.close();
	}catch (IOException e){
	    System.out.println(e);
	}

	try{
	    for(int i=0; i<args.length; i++){
		String fileName=args[i];
		FileReader fileReader = new FileReader(fileName);
		bufferedReader = new BufferedReader(fileReader);
		while((line = bufferedReader.readLine()) != null){
		    Renglon n= new Renglon(line);
		    l.agrega(n);
		}
	    }

	    Lista<Renglon> regresa=l.mergeSort(l);
	    for(Renglon c: regresa)
		System.out.println(c);

	}catch (IOException e){
	    System.out.println("Error reading "+args[0]);

	}

	try{
	    if(bufferedReader != null)
		bufferedReader.close();

	}catch (IOException e){}
    }
}
