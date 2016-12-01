(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectCT', ProjectCT);

	ProjectCT.$inject = [ '$scope', '$log', 'ProjectSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $timeout
	 * @param IndexSV
	 * @returns
	 */
	function ProjectCT($scope, $log, ProjectSV) {
		$log.debug('[ProjectCT] Inicializando...');
		var self = this;

		self.projects = ProjectSV.resource.query();
	}
})();