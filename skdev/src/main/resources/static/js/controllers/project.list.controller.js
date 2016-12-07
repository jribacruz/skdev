(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectListCT', ProjectListCT);

	ProjectListCT.$inject = [ '$scope', '$log', 'ProjectSV', '$mdDialog', '$http' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $timeout
	 * @param IndexSV
	 * @returns
	 */
	function ProjectListCT($scope, $log, ProjectSV, $mdDialog, $http) {
		$log.debug('[ProjectListCT] Inicializando...');
		var self = this;

		self.projects = ProjectSV.resource.query();
	}
})();