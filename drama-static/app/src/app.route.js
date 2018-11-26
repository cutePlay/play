'use strict';

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
});