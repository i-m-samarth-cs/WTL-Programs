class Test 
  def method1 
   puts "This is the first method" 
  end 
  private 
  def method2 
  puts "This is second method" 
  end 
  protected 
  def method3 
    puts "This is third method" 
end 
end 
obj=Test.new() 
obj.method1 
#obj.method2
#obj.method3