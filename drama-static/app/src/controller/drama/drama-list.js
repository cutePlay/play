'use strict';

/**
 * @ngdoc function
 * @name dramaStaticApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the dramaStaticApp
 */
dramaStaticApp
  .controller('DramaListCtrl',['DramaService','$scope','$routeParams', function (DramaService,$scope,$routeParams) {
    console.info($routeParams);
    DramaService.get($routeParams,function(resp){
      /** @namespace resp.records */
      $scope.dramas = resp.records;
      console.info($scope.dramas);
    });
  }]);
