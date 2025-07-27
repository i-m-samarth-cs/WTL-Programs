class A 
  def method1   
    puts "I am in method1 of class A."   
  end   
  def method2   
    puts "I am in method2 of class A."   
  end   
end   
class B < A 
  def method3   
    puts "I am in method3 of class B."   
  end   
end   
obj = B.new   
obj.method1 
obj.method2 
obj.method3 