i=0 
A=Array.new 
puts "Enter the elements in the array" 
while(i<5) 
   val=gets 
   A[i]=val 
    i+=1 
end 
A.sort! 
puts "The sorted array is " 
for val in A 
  puts val 
end 
puts "Serching the elements from an array" 
puts "Enter the number to be searched"

key=gets 
if A.include?(key) 
  puts "The element #{key} is present in the list" 
else 
  puts "The element #{key} is not present in the list" 
end 
