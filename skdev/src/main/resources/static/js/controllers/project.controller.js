(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectCT', ProjectCT);

	ProjectCT.$inject = [ '$scope', '$log', 'ProjectSV', '$mdDialog', '$http' ];

	/**
	 *
	 * @param $scope
	 * @param $log
	 * @param $timeout
	 * @param IndexSV
	 * @returns
	 */
	function ProjectCT($scope, $log, ProjectSV, $mdDialog, $http) {
		$log.debug('[ProjectCT] Inicializando...');
		var self = this;

		self.domainClasses = [];

		self.init = init;

		self.showActionListDialog = showActionListDialog;

		self.findAllDomainClasses = findAllDomainClasses;

		self.loaders = {
			'domainClasses' : true
		}

		/**
		 *
		 */
		function init() {
			self.findAllDomainClasses();
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
		function findAllDomainClasses() {
			$http.get('http://localhost:8080/skdev/api/project/domain/classes')
					.success(function(data) {
						self.domainClasses = data;
						self.loaders['domainClasses'] = false;
					})
					.error(function(response) {
						self.loaders['domainClasses'] = false;
					});
		}

	}
})();
