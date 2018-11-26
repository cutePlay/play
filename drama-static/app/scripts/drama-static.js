/*! drama-static - v1.0.0 - 2018-11-26
* https://github.com/cutePlay/drama-static#readme
* Copyright (c) 2018 ; Licensed  */
'use strict';

// Declare app level module which depends on views, and core components
var dramaStaticApp = angular.module('dramaStaticApp', [
  'ngRoute',
  'ngResource'
]);
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
  .controller('IndexCtrl', function () {
    console.info("test index");
  });
