angular
		.module('app')
		.controller(
				'UserController',
				[
						'$scope',
						'$http',
						'$cookies',
						'$location',
						function($scope, $http, $cookies, $location) {
							//
							// $scope.user = {
							// userId : 1
							// };

							console.log("aaaaaaaaaaaaaa");

							$scope.checkCookie = function() {
								$scope.cookieToken = $cookies
										.get('YearBookToken'); // login.js'den
								// set
								// edilen tokenı
								// aldık.
								if ($scope.cookieToken == null) {
									$location.path('/login.html'); // login
									// sayfası
									// getiricek
									// çünkü
									// cookie boş

								} else { // varsa kullanıcı bilgilerini
									// getiricek.
									$scope.tokenInfo();
								}

							}
							$scope.checkCookie();

							$scope.tokenInfo = function() {

								$scope.userToken = { // userToken diye bi
									// obje oluşturduk.
									token : $scope.cookieToken
								// token özelliğine oluşturduğumuz cookieToken'ı
								// attık.
								}

								$http
										.post(
												'http://localhost:18080/YearBook/user/tokenInfo',
												$scope.userToken)
										.then(
												function(response) {

													$scope.data = response.data.data;
													$scope.error = response.data.error;
													$scope.description = response.data.description;
													$scope.message = response.data.message;

													if ($scope.error == false) {
														$scope.user = response.data.data.user;
													}
													if ($scope.error == true) {
														$location
																.path('/login.html');
													}

												},
												function(response) {
													$scope.content = "Something went wrong;";
												});
							}

							$scope.getUser = function() {

								$http
										.post(
												'http://localhost:18080/YearBook/user/getUser',
												$scope.user)
										.then(
												function(response) {
													$scope.user = response.data;
												},
												function(response) {
													$scope.content = "Something went wrong;";
												});
							}
							$scope.getUser();
						} ]);