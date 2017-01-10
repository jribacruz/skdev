(function() {
	'use strict';

	startup.$inject = [ '$log' ];

	angular.module("skdevMD", [ 'ngResource', 'ngAnimate', 'ngMaterial' ])
		.run(startup)
		.config(function($mdIconProvider) {
			$mdIconProvider
			.defaultIconSet('/skdev/images/mdi.svg')
	});

	function startup($log) {
		$log.debug('[skdevMD] Startup App...');
	}

})();