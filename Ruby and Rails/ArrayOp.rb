arr = Array.new(5)

for i in 0...5
  arr[i] = gets.to_i
  i+=1
end

puts "### MENU ###"
puts "1. Shift"
puts "2. Push"
puts "3. Combiine"
puts "4. Pop"
puts "5. Unshift" 
puts "6. Reverse"
puts "7. Sort"
puts "8. Exit"

choice = gets.to_i

case choice
  when 1
    arr.shift
    puts "After shifting, the array is: #{arr}"
  when 2
    arr.push(get.to_i)
  puts "After pushing, the array is: #{arr}"
  when 3
    arr.combine(get.to_i)
    puts "After combining, the array is: #{arr}"
  when 4
    arr.pop
    puts "After popping, the array is: #{arr}"
  when 5
    arr.unshift(get.to_i)
    puts "After unshifting, the array is: #{arr}"
  when 6
    arr.reverse
    puts "After reversing, the array is: #{arr}"
  when 7
    arr.sort
    puts "After sorting, the array is: #{arr}"
  when 8
    exit
  else
    puts "Invalid choice"
end
