(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectCT', ProjectCT);

	ProjectCT.$inject = [ '$scope', '$log', 'ProjectSV', '$mdDialog', 'httpSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param ProjectSV
	 * @param $mdDialog
	 * @param httpSV
	 * @returns
	 */
	function ProjectCT($scope, $log, ProjectSV, $mdDialog, httpSV) {
		$log.debug('[ProjectCT] Inicializando...');
		var self = this;

		init();

		/**
		 * 
		 */
		function init() {
		}

	}
})();
