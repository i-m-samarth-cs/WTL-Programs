i=0 
 arr=Array.new 
 puts "Enter the elements for the list. Press Cntrl+z for to terminate the list" 
 while(val=gets) 
  arr[i]=val 
  i+=1 
 end 
 first = arr[0] 
  second = arr[0] 
  i=0 
  for value in arr 
    if value < first 
      second = first 
      secondkey=i 
      first = value 
    elsif value < second 
       second = value 
       secondkey=i 
    end 
    i+=1 
  end 
  puts "The smallest element is #{second}and the position is #{secondkey}"