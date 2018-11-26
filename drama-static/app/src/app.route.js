'use strict';

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
});