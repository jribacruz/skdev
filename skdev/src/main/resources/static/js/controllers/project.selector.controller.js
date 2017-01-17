(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectSelectorCT', ProjectSelectorCT);

	ProjectSelectorCT.$inject = [ '$scope', '$log', '$mdDialog', 'projectSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @param $mdDialog
	 * @param HttpSV
	 * @returns
	 */
	function ProjectSelectorCT($scope, $log, $mdDialog, projectSV) {
		$log.debug('[ProjectSelectorCT] Inicializando...');
		var self = this;

		$scope.projects = [];

		$scope.selectedProject = {};

		projectSV.findAll().then(function(res) {
			$scope.projects = res.data;
		});

		$scope.select = function() {
			projectSV.setSelectedProject($scope.selectedProject);
			$mdDialog.hide();
		}

		$scope.cancel = function() {
			$mdDialog.cancel();
		}

	}
})();