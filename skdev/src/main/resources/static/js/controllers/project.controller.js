(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectCT', ProjectCT);

	ProjectCT.$inject = [ '$scope', '$log', 'ProjectSV', '$mdDialog' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $timeout
	 * @param IndexSV
	 * @returns
	 */
	function ProjectCT($scope, $log, ProjectSV, $mdDialog) {
		$log.debug('[ProjectCT] Inicializando...');
		var self = this;

		self.projects = ProjectSV.resource.query();
		
		self.showActionListDialog = showActionListDialog;

		/**
		 * Exibe o dialog com a listagem de actions.
		 */
		function showActionListDialog() {
			$log.debug('[showActionListDialog] Listagem de Actions.')
			$mdDialog.show({
				parent: angular.element(document.body),
				templateUrl: 'http://localhost:8080/skdev/partials/action.list.html',
				clickOutsideToClose:true,
				controller: 'ActionListCT',
				controllerAs: 'actionListCT'
			});
		}
	}
})();