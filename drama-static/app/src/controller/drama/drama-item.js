'use strict';

/**
 * @ngdoc function
 * @name dramaStaticApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the dramaStaticApp
 */
dramaStaticApp
.controller('DramaItemCtrl',['DramaService','$scope','$routeParams', function (DramaService,$scope,$routeParams) {
  // $scope.dramas = [{"id":"abc","title":"t"}];
  console.info($routeParams);
  $scope.drama = DramaService.get($routeParams);
  console.info($scope.drama);

}]);
