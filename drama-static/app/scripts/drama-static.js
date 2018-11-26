/*! drama-static - v1.0.0 - 2018-11-26
* https://github.com/cutePlay/drama-static#readme
* Copyright (c) 2018 ; Licensed  */
'use strict';

// Declare app level module which depends on views, and core components
var dramaStaticApp = angular.module('dramaStaticApp', [
  'ngRoute',
  'ngResource'
])
    .constant("baseUrl",{
      "api":"http://localhost:8088/"
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
                controllerAs: 'index'
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
  .controller('IndexCtrl', function (DramaService) {
    var list = DramaService.query();
    DramaService.get({id:1},function(resp){console.info(resp)});
    console.info(list);
    console.info("test index");
  });
;dramaStaticApp
  .factory('DramaService',function(baseUrl,$resource){
    return $resource(baseUrl.api+"api/dramas/:id",
        {id:'@id'},
        {query:{method:"GET",isArray:true}});
  });