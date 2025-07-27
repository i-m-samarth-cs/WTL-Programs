def myfun 
   puts "This statement is in method" 
   yield 
   puts "Returning back to the method" 
end 
myfun {puts "This statement is in block"}