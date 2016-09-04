var app = angular.module('app', ['ngCookies']);
app.controller('TestCookieController', function($scope, $http, $cookies) {
	$cookies.put('YearBookToken', "asdasdasdasd");
	$scope.myCookieVal = $cookies.get('YearBookToken');
	console.log("$scope.myCookieVal:  "+$scope.myCookieVal)
});


//dslkdlskdslkdslkdsldsl