'use strict';

/**
 * @ngdoc function
 * @name dramaStaticApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the dramaStaticApp
 */
dramaStaticApp
  .controller('DramaCtrl',['baseUrl','DramaService','$scope', function (baseUrl,DramaService,$scope) {
    console.info("drama");
    // $scope.dramas = [{"id":"abc","title":"t"}];
    $scope.dramas = DramaService.query();
    $scope.baseUrl = baseUrl;
    console.info($scope.dramas);
  }]);
