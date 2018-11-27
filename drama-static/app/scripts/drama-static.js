/*! drama-static - v1.0.0 - 2018-11-27
* https://github.com/cutePlay/drama-static#readme
* Copyright (c) 2018 ; Licensed  */
'use strict';

// Declare app level module which depends on views, and core components
var dramaStaticApp = angular.module('dramaStaticApp', [
  'ngRoute',
  'ngResource'
]);

dramaStaticApp.constant("baseUrl",{
      "api":"http://localhost:8088",
      "img":"http://localhost:8088"
    })
;

'use strict';

dramaStaticApp.
    config(function($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');
        $routeProvider
            .when('/',{
                templateUrl: 'templates/index.html',
            })
            .when('/dramas',{
                templateUrl: 'templates/drama/list.html'
            })
            .when('/dramas/:id',{
                templateUrl: 'templates/drama/item.html'
            })
            .otherwise({redirectTo: '/'});
});
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

'use strict';

/**
 * @ngdoc function
 * @name dramaStaticApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the dramaStaticApp
 */
dramaStaticApp
  .controller('IndexCtrl',[function () {
    console.info("test index ok");
  }]);

dramaStaticApp
  .directive('embedSrc',function(){
    return {
      restrict: 'A',
      link: function (scope, element, attrs) {
        var current = element;
        scope.$watch(function() { return attrs.embedSrc; }, function () {
          var clone = element
          .clone()
          .attr('src', attrs.embedSrc);
          current.replaceWith(clone);
          current = clone;
        });
      }
    };
  });
dramaStaticApp
  .filter('baseImg',function (baseUrl) {
    return function(text){
      if(text&&!text.startsWith("/")){
        return baseUrl.img+"/"+text;
      }
      return baseUrl.img + text;
    }
  });
dramaStaticApp
  .service('DramaService',['baseUrl','$resource',function(baseUrl,$resource){
    return $resource(baseUrl.api+"/api/dramas/:id/:url",
        {id:'@id',url:'@url'});
  }]);
