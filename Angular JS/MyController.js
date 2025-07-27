angular.module('MyApp', []).controller('MyController', function($scope) {   
    $scope.user = "AAA";   
    $scope.city = "Pune";   
    $scope.address_function=function() { 
     return $scope.user+" "+$scope.city; 
   }  
});   