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