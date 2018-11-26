/*! drama-static - v1.0.0 - 2018-11-26
* https://github.com/cutePlay/drama-static#readme
* Copyright (c) 2018 ; Licensed  */
'use strict';

// Declare app level module which depends on views, and core components
var dramaStaticApp = angular.module('dramaStaticApp', [
  'ngRoute',
  'ngResource'
]);

dramaStaticApp.constant("baseUrl",{
      "api":"http://localhost:8088/",
      "img":"http://localhost:8088/"
    })
;
;'use strict';

dramaStaticApp.
    config(function($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');
        $routeProvider
            .when('/',{
                templateUrl: 'templates/index.html',
                controller: 'IndexCtrl',
            })
            .when('/dramas',{
                templateUrl: 'templates/drama/list.html',
                controller: 'DramaCtrl',
            })
            .otherwise({redirectTo: '/'});
});;'use strict';

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
;'use strict';

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
;dramaStaticApp
  .service('DramaService',['baseUrl','$resource',function(baseUrl,$resource){
    return $resource(baseUrl.api+"api/dramas/:id",
        {id:'@id'});
  }]);
