# --- Demonstrating sub! ---

# Initialize the first string
str = "PHP is a fun. I like PHP"
puts "Original string (str): \"#{str}\""

# Use sub! to replace the FIRST occurrence of "PHP" with "Ruby"
# The '!' indicates that the method modifies the string IN-PLACE.
str.sub!(/PHP/, "Ruby")

# Print the modified string to show the effect of sub!
puts "After str.sub!(\"PHP\", \"Ruby\"): \"#{str}\""
puts # Add a blank line for better readability

# --- Demonstrating gsub! ---

# Initialize the second string
str1 = "Java is OOP.I program in Java"
puts "Original string (str1): \"#{str1}\""

# Use gsub! to replace ALL occurrences of "Java" with "Ruby"
# The '!' indicates that the method modifies the string IN-PLACE.
str1.gsub!(/Java/, "Ruby")

# Print the modified string to show the effect of gsub!
puts "After str1.gsub!(\"Java\", \"Ruby\"): \"#{str1}\""