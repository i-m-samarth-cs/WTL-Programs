# Define the string to be matched
pattern = "Anuradha-19999"

# Perform the regular expression match
# The `=~` operator attempts to match the regex against the string.
# If a match is found, it returns the starting index of the match (0 in this case, as it matches from the beginning).
# If no match is found, it returns nil.
# Importantly, when a match occurs, the captured groups are stored in special global variables:
# $1 for the first captured group, $2 for the second, and so on.
pattern =~ /(\w+)-(\d+)/

# Print the content of the first captured group ($1)
puts "First string is #{$1}"

# Print the content of the second captured group ($2)
puts "Second string is #{$2}"