var app = angular.module('myApp', []);
app.controller('testController', function($scope, $http) {
	$scope.username = "John";
	$scope.userMail = "Doe";
	$scope.fullName = function() {
		return $scope.username + " " + $scope.userMail;
	};

	$scope.userList = [];

	$scope.addUserToList = function() {
		var user = {
			username : $scope.username,
			userMail : $scope.userMail,
		}
		$scope.userList.push(user);
		console.log($scope.fullName());
	};

	$scope.addUser = function() {
		var user = {
			username : $scope.username,
			userMail : $scope.userMail,
		}

		var requestURL = "http://localhost:18080/YearBook/user/add";
		$http.post(requestURL, user).then(function(response) {
			// First function handles success
			$scope.content = response.data;
		}, function(response) {
			// Second function handles error
			$scope.content = "Something went wrong";
		});

		$scope.userList.push(user);
		console.log($scope.fullName());
	};

	$scope.getList = function() {
		var user = {};

		var requestURL = "http://localhost:18080/YearBook/user/list";
		$http.post(requestURL, user).then(function(response) {
			$scope.userList = response.data;
		}, function(response) {
			$scope.content = "Something went wrong";
		});

		console.log($scope.fullName());
	};
	//$scope.getList();

}); 