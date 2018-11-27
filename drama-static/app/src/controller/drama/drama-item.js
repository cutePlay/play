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
  DramaService.get($routeParams,function(resp){
    $scope.drama = resp;
  });
  DramaService.get({url:"roles",id:$routeParams.id},{},function(resp){
    console.info(resp);
  });
  $scope.showBrief = function(){
    console.info("brief");
  }

}]);
