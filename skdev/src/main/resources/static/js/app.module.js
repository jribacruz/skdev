(function() {
	'use strict';

	startup.$inject = [ '$log' ];

	angular.module("skdevMD", [ 'ngResource', 'ngAnimate', 'webix' ])
		.run(startup);

	function startup($log) {
		$log.debug('[skdevMD] Startup App...');
	}

})();