package example.java8;

import java.util.Arrays;
import java.util.function.Supplier;

import org.aspectj.lang.annotation.Aspect;

public class Lambda {
	public static void main(String[] args) {
//		Arrays.asList( "a", "b", "d" ).forEach( e -> {
//		    System.out.print( e );
//		    System.out.print( e );
//		} );
		
		Car.create(Car::new);
		
	}
	
	public static class Car {
	    public static Car create( final Supplier< Car > supplier ) {
	        return supplier.get();
	    }     
	    

	    public static void collide( final Car car ) {
	        System.out.println( "Collided " + car.toString() );
	    }
	         
	    public void follow( final Car another ) {
	        System.out.println( "Following the " + another.toString() );
	    }
	         
	    public void repair() {   
	        System.out.println( "Repaired " + this.toString() );
	    }
	}
	

}
