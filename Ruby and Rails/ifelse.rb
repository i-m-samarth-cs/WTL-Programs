puts "Enter Age "
age = gets.to_i
if age>=18
  puts "You are eligible to vote"
elsif age<18 && age>=0
  puts "You are not eligible to vote"
else 
  puts "Invalid input"  
end