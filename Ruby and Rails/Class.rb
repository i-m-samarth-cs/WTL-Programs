class Student 
   @@TotalStudents=0    // Class or Local Variable
   def initialize(roll, name, marks) 
      @stud_roll=roll  // Instance or Local Variable
      @stud_name=name 
      @stud_marks=marks 
   end 
   def display() 
      puts "Roll Number: #@stud_roll" 
      puts "name: #@stud_name" 
      puts "Marks: #@stud_marks" 
    end 
    def total() 
       @@TotalStudents += 1 
       puts "\tTotal number of students: #@@TotalStudents" 
    end 
end 
S1=Student.new("1", "Shilpa", 97.11)
S2=Student.new("2", "Rashmi", 89.21) 
# Call Methods 
S1.display() 
S1.total() 
puts "---------------------------------------------------" 
S2.display() 
S2.total() 