(function() {
	'use strict';

	startup.$inject = [ '$log', 'HttpSV' ];

	angular.module("skdevMD", [ 'ngResource', 'ngAnimate', 'ngMaterial' ]).run(
			startup);

	function startup($log, HttpSV) {
		$log.debug('[skdevMD] Startup App...');

		/*
		 * Registra os DataHandlers da Applicação.
		 */
		/*HttpSV.$dh([ "classes:/project/classes/{id}:true",
				"actions:/actions/{id}:true", "projects:/projects/{id}:true" ]);*/
	}

})();