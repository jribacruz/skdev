(function() {
	'use strict';

	startup.$inject = [ '$log' ];

	angular.module("skdevMD", [ 'ngResource', 'ngAnimate', 'ngMaterial', 'md.data.table' ])
		.run(startup)
		.config(function($mdIconProvider) {
			$mdIconProvider
				.defaultIconSet('/skdev/images/mdi.svg')
		});

	function startup($log) {
		$log.debug('[skdevMD] Startup App...');

		/*
		 * Registra os DataHandlers da Applicação.
		 */
		/*HttpSV.$dh([ "classes:/project/classes/{id}:true",
				"actions:/actions/{id}:true", "projects:/projects/{id}:true" ]);*/
	}

})();