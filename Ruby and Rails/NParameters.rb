def testmethod1(*arg) 
   puts "The total number of parameters are: #{arg.length}" 
   for i in 0...arg.length 
      puts "The parameters are #{arg[i]}" 
   end 
end 
testmethod1 10,20,30 
testmethod1 11.1,12.2,13.3,14.4,15.5 