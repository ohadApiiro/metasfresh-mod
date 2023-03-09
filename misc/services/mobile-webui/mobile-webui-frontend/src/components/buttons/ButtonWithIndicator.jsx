import React from 'react';
import PropTypes from 'prop-types';
import cx from 'classnames';

import * as CompleteStatus from '../../constants/CompleteStatus';
import HazardIcon from '../HazardIcon';
import AllergenIcon from '../AllergenIcon';

const SYMBOLS_SIZE_PX = 25;

const ButtonWithIndicator = ({
  caption,
  showWarningSign,
  typeFASIconName,
  hazardSymbols = null,
  allergens = null,
  isDanger,
  completeStatus,
  disabled,
  onClick,
  children,
}) => {
  const indicatorClassName = getIndicatorClassName(completeStatus);

  const showHazardsAndAllergens = hazardSymbols != null || allergens != null;

  return (
    <button
      className={cx('button is-outlined is-fullwidth complete-btn', { 'is-danger': isDanger })}
      disabled={!!disabled}
      onClick={onClick}
    >
      <div className="full-size-btn">
        <div className="left-btn-side">
          {showWarningSign && <i className="fas fa-exclamation-triangle warning-sign" />}
          {typeFASIconName && <i className={`fas fa-solid ${typeFASIconName}`} />}
        </div>
        <div className="caption-btn">
          <div className="rows">
            <div className="row">
              <span>{caption}</span>
            </div>
            {showHazardsAndAllergens && (
              <div
                className="row hazard-icons-btn"
                style={{
                  minHeight: SYMBOLS_SIZE_PX + 'px',
                  maxHeight: SYMBOLS_SIZE_PX + 'px',
                }}
              >
                <AllergenIcon allergens={allergens} size={SYMBOLS_SIZE_PX} />
                {hazardSymbols &&
                  hazardSymbols.map((hazardSymbol, symbolIndex) => (
                    <HazardIcon
                      key={symbolIndex}
                      imageId={hazardSymbol.imageId}
                      caption={hazardSymbol.name}
                      size={SYMBOLS_SIZE_PX}
                    />
                  ))}
              </div>
            )}
            {children}
          </div>
        </div>
        {indicatorClassName && (
          <div className="right-btn-side">
            <span className={indicatorClassName} />
          </div>
        )}
      </div>
    </button>
  );
};

const getIndicatorClassName = (completeStatus) => {
  switch (completeStatus) {
    case CompleteStatus.NOT_STARTED:
      return 'indicator-red';
    case CompleteStatus.COMPLETED:
      return 'indicator-green';
    case CompleteStatus.IN_PROGRESS:
      return 'indicator-yellow';
    default:
      return '';
  }
};

ButtonWithIndicator.propTypes = {
  caption: PropTypes.string.isRequired,
  showWarningSign: PropTypes.bool,
  typeFASIconName: PropTypes.string,
  hazardSymbols: PropTypes.array,
  allergens: PropTypes.array,
  isDanger: PropTypes.bool,
  completeStatus: PropTypes.string,
  disabled: PropTypes.bool,
  children: PropTypes.node,
  onClick: PropTypes.func.isRequired,
};

export default ButtonWithIndicator;
