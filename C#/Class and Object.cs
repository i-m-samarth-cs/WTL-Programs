using System; 
using System.Collections.Generic; 
using System.Linq; 
using System.Text; 
 
namespace ConsoleApplication2 
{ 
    class Circle
    { 
        double radius; 
        double pi=3.14; 
        double a; 
        public void getdata() 
        { 
            radius = 10; 
        } 
        public void area() 
        { 
           a = pi * radius * radius;        
          Console.WriteLine("Radius: {0}", radius); 
          Console.WriteLine("Area: {0}", a);  
        } 
    } 
    class Program 
    { 
        static void Main(string[] args) 
        { 
            Circle obj = new Circle(); 
            obj.getdata(); 
            obj.area(); 
            Console.ReadKey(); 
        } 
    }
}