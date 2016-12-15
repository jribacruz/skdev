(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectCT', ProjectCT);

	ProjectCT.$inject = [ '$scope', '$log', 'ProjectSV', '$mdDialog', '$http', 'HttpSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $timeout
	 * @param IndexSV
	 * @returns
	 */
	function ProjectCT($scope, $log, ProjectSV, $mdDialog, $http, HttpSV) {
		$log.debug('[ProjectCT] Inicializando...');
		var self = this;

		self.domainClasses = [];

		self.init = init;

		self.showActionListDialog = showActionListDialog;

		self.findAllDomainClasses = findAllDomainClasses;

		//self.loaders = HttpSV.registerLoaders(["domainClasses:/project/domain/classes:true"]);
		
		//console.log("=====");
		
		self.dataHandler = HttpSV.registerDataHandlers(["domainClasses:/project/domain/classes:true"]);
		
		//console.log(self.dataHandler);
		
		/*
		var queryParams = {
		}
		
		console.log('Hello, {id}!'.format(queryParams));
		*/
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
			HttpSV.get('domainClasses');
		}

	}
})();
