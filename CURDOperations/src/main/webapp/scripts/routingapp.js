

var app = angular.module("myRouting",["ngRoute"]);

app.config(function($routeProvider){

$routeProvider.when("/home",{
	
    templateUrl :"home.html"
    	
 })
 
 .when("/update",{
	
    templateUrl :"update.html",
    controller: 'myUpdateCtrl'
    	
 })

.when("/registration",{
	templateUrl :"registration.html",
	controller: 'myRegisterCtrl'
})


.when("/employees",{
	templateUrl :"employees.html",
	controller:'getAllEmployeeCtrl'	
})


.when("/delete",{
	templateUrl :"delete.html",
	controller:	"myDeleteCtrl"
})


.otherwise({redirectTo:"/"});

});

	app.controller("myRegisterCtrl",function($scope, $http, $window){

		$scope.registeruser = function(){
			
			var parameter = JSON.stringify({
			
			firstname : $scope.fname,
			lastname  : $scope.lname,
			phonenumber : $scope.phonenum,
			emailid : $scope.email,
			gender :  $scope.mygender
			        
			})
			
			$http(	
					{
						method: 'POST',
						url:'http://localhost:8080/CURDOperations/operations/rest/registration',
						data: parameter,
						headers:
						{
							'Content-Type':'application/json'
						}
					}
					
					).then(function(result){

					$scope.JsonProductList = result.data;
					
					$window.alert("Registration Success..!!!")
					
				}, function(result) {

					$window.alert("ajax failed")
				});
		}
		
	});
	
app.controller("myUpdateCtrl",function($scope, $http, $window){
		
 $scope.updateuser = function(){
			
			var parameter = JSON.stringify({
			
			firstname : $scope.fname,
			phonenumber : $scope.phonenum
			        
			})
		
			$http({
						method: 'POST',
						url:'http://localhost:8080/CURDOperations/operations/rest/update',
						data: parameter,
						headers:
						{
							'Content-Type':'application/json'
						}
					}
					
					).then(function(result){

					$scope.JsonProductList = result.data;
					
				}, function(result) {

					$window.alert("ajax failed in updation")
				});
}
	});


app.controller("getAllEmployeeCtrl",function($scope, $http, $window){
	
	 $scope.getAllEmp = function(){
				
		 $scope.n =5;
				$http({
							method: 'GET',
							url:'http://localhost:8080/CURDOperations/operations/rest/employees',
							
							headers:
							{
								'Content-Type':'application/json'
							}
						}
				
						).then(function(result){

						$scope.Emplist = result.data;
						
					}, function(result) {

						$window.alert("ajax failed in updation")
					});
	}
		
});

app.controller("myDeleteCtrl",function($scope, $http, $window){
	
	 $scope.deleteUser = function(){
				
				var parameter = JSON.stringify({
				
				firstname : $scope.fname,
				     
				})
			
				$http({
							method: 'POST',
							url:'http://localhost:8080/CURDOperations/operations/rest/delete',
							data: parameter,
							headers:
							{
								'Content-Type':'application/json'
							}
						}
						
						).then(function(result){

						$scope.JsonProductList = result.data;
						
					}, function(result) {

						$window.alert("ajax failed in updation")
					});
	}
		});

	
	
	

