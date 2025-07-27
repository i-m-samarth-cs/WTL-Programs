A = Hash.new( "one" ) 
puts "\tFirst Method of Hash Creation" 
puts "#{A[0]}" 
puts "#{A[3]}" 
puts "#{A[5]}" 
puts "\tSecond Method of Hash Creation" 
B=Hash["AAA"=>100,"BBB"=>200,"CCC"=>300] 
puts "#{B['AAA']}" 
puts "#{B['BBB']}" 
puts "#{B['CCC']}" 
puts "\t Displaying the keys of the array" 
keys=B.keys 
puts "#{keys}" 