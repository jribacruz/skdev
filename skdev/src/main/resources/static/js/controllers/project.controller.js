(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectCT', ProjectCT);

	ProjectCT.$inject = [ '$scope', '$log', 'ProjectSV', '$mdDialog', '$http', 'HttpSV', '$location' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param ProjectSV
	 * @param $mdDialog
	 * @param $http
	 * @param HttpSV
	 * @returns
	 */
	function ProjectCT($scope, $log, ProjectSV, $mdDialog, $http, HttpSV, $location) {
		$log.debug('[ProjectCT] Inicializando...');
		var self = this;

		self.domainClasses = [];

		self.init = init;

		self.showActionListDialog = showActionListDialog;

		self.classes = [];
		
		self.findAllClassesLoader = true;
		
		self.projectName = URI($location.absUrl()).search(true).name;
		
		console.log(URI($location.absUrl()).search(true).name);

		/**
		 * 
		 */
		function init() {
			findAllClasses();
		}

		/**
		 * Exibe o dialog com a listagem de actions.
		 */
		function showActionListDialog() {
			$log.debug('[showActionListDialog] Listagem de Actions.')
			$mdDialog.show({
				parent : angular.element(document.body),
				templateUrl : '/skdev/partials/action.list.html',
				clickOutsideToClose : false,
				controller : 'ActionListCT',
				controllerAs : 'actionListCT'
			});
		}

		/**
		 * 
		 */
		function findAllClasses() {
			HttpSV.get('/project/classes').then(function(data) {
				self.classes = data;
				self.findAllClassesLoader = false;
			});
		}

	}
})();
