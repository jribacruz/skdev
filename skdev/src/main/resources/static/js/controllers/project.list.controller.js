(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectListCT', ProjectListCT);

	ProjectListCT.$inject = [ '$scope', '$log', '$mdDialog', 'HttpSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdDialog
	 * @param HttpSV
	 * @returns
	 */
	function ProjectListCT($scope, $log, $mdDialog, HttpSV) {
		$log.debug('[ProjectListCT] Inicializando...');
		var self = this;

		self.projects = HttpSV.$dh('projects');

		HttpSV.get('projects');
	}
})();